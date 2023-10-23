import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoController(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    @GetMapping
    public List<Medicamento> listarMedicamentos() {
        return medicamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Medicamento obterMedicamento(@PathVariable Long id) {
        return medicamentoRepository.findById(id)
                .orElseThrow(() -> new MedicamentoNotFoundException(id));
    }
}