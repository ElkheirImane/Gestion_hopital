package ma.emsi.patientsmvc.web;

import lombok.AllArgsConstructor;
import ma.emsi.patientsmvc.entities.Medecin;
import ma.emsi.patientsmvc.repositories.MedecinRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class MedecinController {


    private MedecinRepository medecinsRepository;

    @GetMapping(path = "/user/medecin")
    public String medecin(Model model,
                         @RequestParam (name = "page",defaultValue = "0") int page,
                          @RequestParam (name = "size",defaultValue = "5")int size,
                          @RequestParam (name = "keyword",defaultValue = "") String keyword

    ){
        Page<Medecin> pageMedecins= medecinsRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listMedecins",pageMedecins.getContent());
        //getContent() affiche la liste  des patients de la page
        model.addAttribute("pages",new int [pageMedecins.getTotalPages()]);
        model.addAttribute("currentPage",page);//la page courante
        model.addAttribute("keyword" ,keyword);
        return "medecin";
    }
    @GetMapping("/admin/deleteMed")
    public String deleteMed(Long id, String keyword, int page){
        medecinsRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    // METHODE POUR RETOURNER LA LISTE DES PATIENTS
    /*@GetMapping("/user/medecins")
    @ResponseBody
    public List<Medecin> listMedecins(){
        return medecinsRepository.findAll();
    }*/

    @GetMapping("/admin/formMedecin")
    public String formMedecins (Model model){
        model.addAttribute("medecin",new Medecin());
        return "formMedecin";
    }
@PostMapping(path="/admin/saveMed")
    public String saveMed(Model model, @Valid Medecin medecin, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if (bindingResult.hasErrors()) return "formMedecin";
       medecinsRepository.save(medecin);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/admin/editMedecin")
    public String editMed(Model model,Long id,String keyword, int page){
        Medecin medecin=medecinsRepository.findById(id).orElse(null);
        if (medecin==null) throw new RuntimeException("Medecin introuvable");
        model.addAttribute("medecin",medecin);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);

        return "editMedecin";
    }
}
