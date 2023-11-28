package dev.aniket.findjobproject.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;

@Document(collection = "JobPost")
public class Post
{
    @Field("profile")
    private String _profile;
    @Field("desc")
    private String _description;
    @Field("exp")
    private int _experience;
    @Field("techs")
    private String[] _technologies;

    public Post()
    {

    }

    @Override
    public String toString()
    {
        return "Post{" +
                "_profile='" + _profile + '\'' +
                ", _description='" + _description + '\'' +
                ", _experience=" + _experience +
                ", _technologies=" + Arrays.toString(_technologies) +
                '}';
    }
}
