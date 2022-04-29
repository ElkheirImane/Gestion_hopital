package ma.emsi.patientsmvc.web;

import lombok.AllArgsConstructor;
import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping(path = "/user/index")
    public String patient(Model model,
                         @RequestParam (name = "page",defaultValue = "0") int page,
                          @RequestParam (name = "size",defaultValue = "5")int size,
                          @RequestParam (name = "keyword",defaultValue = "") String keyword

    ){
        Page<Patient> pagePaitients=patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePaitients.getContent());
        //getContent() affiche la liste  des patients de la page
        model.addAttribute("pages",new int [pagePaitients.getTotalPages()]);
        model.addAttribute("currentPage",page);//la page courante
        model.addAttribute("keyword" ,keyword);
        return "patient";
    }
    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home() {
        return "home";
    }
    // METHODE POUR RETOURNER LA LISTE DES PATIENTS
    @GetMapping("/user/patients")
    @ResponseBody
    public List<Patient> lisPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/admin/formPatient")
    public String formPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }
    @PostMapping(path="/admin/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if (bindingResult.hasErrors()) return "formPatient";
        patientRepository.save(patient);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/editPatient")
    public String editPatient(Model model,Long id,String keyword, int page){
        Patient patient=patientRepository.findById(id).orElse(null);
        if (patient==null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("patient",patient);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);

        return "editPatient";
    }
}
