package ibf2022.paf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7

@Service
public class TodoService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Transactional
    public int upsertTask(String username, List<Task> tasks){
        
        User user;
        Optional<User> userOp = userRepository.findUserByUsername(username);
        
        if (!userOp.isEmpty()){
            user = userOp.get();
        }else{
            user = new User();
            user.setUsername(username);
            String userID = userRepository.insertUser(user);
            if (!(userID==null)) {
                user.setUserId(userID);
            }
        }

        int taskCount = 0;

        for (Task task:tasks){
            taskRepository.insertTask(username, task);
            taskCount +=1;
        }

        return taskCount;
    }
}
