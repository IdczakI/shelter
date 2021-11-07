package pl.idczak.shelter.dog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dogs")
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("")
    public String findNonAdoptedDogs(Model model, @RequestParam(required = false) String phrase) {
        if (phrase == null || "".equals(phrase))
            model.addAttribute("dogs", dogService.findAllNonAdoptedDogs());
        else
            model.addAttribute("dogs", dogService.findAllNonAdoptedDogsByRegex(phrase));
        return "/dog/dogs_in_shelter";
    }

    @GetMapping("adopted")
    public String findAdoptedDogs(Model model, @RequestParam(required = false) String phrase) {
        if (phrase == null || "".equals(phrase))
            model.addAttribute("dogs", dogService.findAllAdoptedDogs());
        else
            model.addAttribute("dogs", dogService.findAllAdoptedDogsByRegex(phrase));
        return "dog/dogs_adopted";
    }
}
