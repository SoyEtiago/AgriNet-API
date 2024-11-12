import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AggregationController {

    @Autowired
    private AggregationService aggregationService;

    @GetMapping("/chat/{idChat}/participantes")
    public List<Map<String, Object>> getParticipantesChat(@PathVariable String idChat) {
        return aggregationService.getParticipantesChat(idChat);
    }

    @GetMapping("/proyecto/{idProyecto}/colaboradores")
    public List<Map<String, Object>> getColaboradoresProyecto(@PathVariable String idProyecto) {
        return aggregationService.getColaboradoresProyecto(idProyecto);
    }

    @GetMapping("/proyecto/{idProyecto}/estado")
    public Map<String, Object> getEstadoProyecto(@PathVariable String idProyecto) {
        return aggregationService.getEstadoProyecto(idProyecto);
    }

    @GetMapping("/usuario/{idUsuario}/proyectos-colaborador")
    public long getProyectosColaborador(@PathVariable String idUsuario) {
        return aggregationService.getProyectosColaborador(idUsuario);
    }
}
