package com.basov.springbootjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "file_type")
@ApiModel("Сущность типа файла")
public class FileType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID типа файла")
    private int id;

    @Column(name = "type")
    @NotNull
    @ApiModelProperty(value = "Тип файла")
    private String type;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "file_type_id")
    @ApiModelProperty(value = "Список фалов принадлежащих данному типу фйала")
    private List<File> fileList;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "author_types"
            , joinColumns = @JoinColumn(name = "type_id")
            , inverseJoinColumns = @JoinColumn(name = "author_id"))
    @ApiModelProperty(value = "Список артистов принадлежащему данному типу фйала")
    private List<Author> authorList;

    public FileType() {
    }

    public FileType(String type, List<File> fileList) {
        this.type = type;
        this.fileList = fileList;
    }

    public void addAuthor(Author author) {
        if (authorList == null) {
            authorList = new ArrayList<>();
        }

        authorList.add(author);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", fileList=" + fileList +
                ", authorList=" + authorList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileType fileType = (FileType) o;
        return id == fileType.id && Objects.equals(type, fileType.type) && Objects.equals(fileList, fileType.fileList) && Objects.equals(authorList, fileType.authorList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, fileList, authorList);
    }
}
