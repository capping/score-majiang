package com.sevengod.score.pojo;

public class Questions {
    private Integer id;

    private String tit;

    private String title;

    private Options[] options;;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Options[] getOptions() {
        return options;
    }

    public void setOptions(Options[] options) {
        this.options = options;
    }
}
