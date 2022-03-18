package com.basov.springbootjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors")
@ApiModel("Сущность автора")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID автора")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @ApiModelProperty(value = "Имя автора")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 30, message = "Surname should be between 2 and 30 characters")
    @ApiModelProperty(value = "Фамилия автора")
    private String surname;

    @Column(name = "payment_status")
    @ApiModelProperty(value = "Статус оплаты автора")
    private int paymentStatus;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    @ApiModelProperty(value = "Список файлов пренадлежащих автору")
    private List<File> fileList;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "author_types"
            , joinColumns = @JoinColumn(name = "author_id")
            , inverseJoinColumns = @JoinColumn(name = "type_id"))
    @ApiModelProperty(value = "Список типов файлов пренадлежащих автору")
    private List<FileType> fileTypeList;

    public Author() {
    }

    public Author(String name, String surname, int paymentStatus, List<File> fileList) {
        this.name = name;
        this.surname = surname;
        this.paymentStatus = paymentStatus;
        this.fileList = fileList;
    }

    public void addFileType(FileType fileType) {
        if (fileTypeList == null) {
            fileTypeList = new ArrayList<>();
        }
        fileTypeList.add(fileType);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public List<FileType> getFileTypeList() {
        return fileTypeList;
    }

    public void setFileTypeList(List<FileType> fileTypeList) {
        this.fileTypeList = fileTypeList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", fileList=" + fileList +
                ", fileTypeList=" + fileTypeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && paymentStatus == author.paymentStatus && Objects.equals(name, author.name) && Objects.equals(surname, author.surname) && Objects.equals(fileList, author.fileList) && Objects.equals(fileTypeList, author.fileTypeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, paymentStatus, fileList, fileTypeList);
    }
}
