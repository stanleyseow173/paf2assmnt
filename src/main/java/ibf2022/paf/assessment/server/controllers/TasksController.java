package ibf2022.paf.assessment.server.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8

@Controller
public class TasksController {

    @Autowired
    TodoService todoService;

    @PostMapping(path="/task")
    public ModelAndView saveTask(@RequestBody MultiValueMap<String, String> formdata, Model model){
        
        String username = formdata.getFirst("username");
        System.out.println("username-->"+ username);
        int taskCount = (formdata.size()-1)/3;

        List<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i<taskCount; i++){
            Task task = new Task();
            task.setDescription(formdata.getFirst("description-%d".formatted(i)));
            task.setPriority(Integer.parseInt(formdata.getFirst("priority-%d".formatted(i))));
            task.setDate(LocalDate.parse(formdata.getFirst("dueDate-%d".formatted(i))));
            tasks.add(task);
        }

        ModelAndView mv = new ModelAndView();

        todoService.upsertTask(username, tasks);

        try{
            
            model.addAttribute("taskCount", taskCount);
            model.addAttribute("username", username);
            mv.setStatus(HttpStatusCode.valueOf(200));
            mv.setViewName("result");
        }catch (Exception e){
            mv.setViewName("error");
            mv.setStatus(HttpStatusCode.valueOf(500));
        }
        

        return mv;
    }
}
