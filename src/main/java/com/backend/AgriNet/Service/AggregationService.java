import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AggregationService {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Mostrar las personas en un chat
    public List<Map<String, Object>> getParticipantesChat(String idChat) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(org.springframework.data.mongodb.core.query.Criteria.where("_id").is(idChat)),
                Aggregation.lookup("usuarios", "usuarios", "_id", "detallesUsuarios"),
                Aggregation.project("detallesUsuarios.nombre", "detallesUsuarios.email")
        );

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "mensajesPriv", Map.class);
        return results.getMappedResults();
    }

    // Colaboradores de un proyecto
    public List<Map<String, Object>> getColaboradoresProyecto(String idProyecto) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(org.springframework.data.mongodb.core.query.Criteria.where("_id").is(idProyecto)),
                Aggregation.lookup("usuarios", "colaboradores.usuarioId", "_id", "detallesColaboradores"),
                Aggregation.project("detallesColaboradores.nombre", "detallesColaboradores.email")
        );

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "proyectos", Map.class);
        return results.getMappedResults();
    }

    // Estado de un proyecto
    public Map<String, Object> getEstadoProyecto(String idProyecto) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(org.springframework.data.mongodb.core.query.Criteria.where("_id").is(idProyecto)),
                Aggregation.project("estado")
        );

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "proyectos", Map.class);
        return results.getUniqueMappedResult();
    }

    // Número de proyectos donde el usuario es colaborador
    public long getProyectosColaborador(String idUsuario) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(org.springframework.data.mongodb.core.query.Criteria.where("colaboradores.usuarioId").is(idUsuario)),
                Aggregation.count().as("totalProyectos")
        );

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "proyectos", Map.class);
        Map<String, Object> countResult = results.getUniqueMappedResult();
        return countResult != null ? (long) countResult.get("totalProyectos") : 0;
    }
}
