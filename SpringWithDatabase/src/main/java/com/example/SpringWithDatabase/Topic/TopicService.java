package com.example.SpringWithDatabase.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

       private static List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic( "Spring" , "Spring Framework" , "Spring Framework Description"),
                new Topic( "Java" , "Java Framework" , "Java Framework Description"),
                new Topic( "Javascript" , "Javascript Framework" , "Javascript Framework Description")
        ));

    public List<Topic> getAllTopics() {
           //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }
       public Topic getTopic(String id){
           return topics.stream().filter( t -> t.getId().equals(id) ).findFirst().get();
       }

    public void addTopic(Topic topic) {
           topicRepository.save(topic);
    }

    public static void updateTopic(String id, Topic topic) {
            for( int i  =0 ; i < topics.size() ; i++)
            {
                Topic t = topics.get(i);
                if( t.getId().equals(id)) {
                    topics.set(i, topic);
                    return;
                }
            }

    }

    public static void deleteTopic(String id) {
        topics.removeIf( t -> t.getId().equals(id));
    }

}
