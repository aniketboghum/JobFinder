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

    public String get_profile()
    {
        return _profile;
    }

    public void set_profile(String _profile)
    {
        this._profile = _profile;
    }

    public String get_description()
    {
        return _description;
    }

    public void set_description(String _description)
    {
        this._description = _description;
    }

    public int get_experience()
    {
        return _experience;
    }

    public void set_experience(int _experience)
    {
        this._experience = _experience;
    }

    public String[] get_technologies()
    {
        return _technologies;
    }

    public void set_technologies(String[] _technologies)
    {
        this._technologies = _technologies;
    }

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
