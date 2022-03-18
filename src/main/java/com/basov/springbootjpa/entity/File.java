package com.basov.springbootjpa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "files")
@ApiModel("Сущность файла")
public class File {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID файла")
    private int id;

    @Column(name = "file_name")
    @ApiModelProperty(value = "Имя файла")
    @NotNull
    @Pattern(regexp = ".+\\.zip")
    private String fileName;

    @Column(name = "track_name")
    @NotNull
    @ApiModelProperty(value = "Название трека")
    private String trackName;

    @Column(name = "placements")
    @ApiModelProperty(value = "Количество плейсментов")
    private int placements;

    @Column(name = "author_id")
    @NotNull
    @ApiModelProperty(value = "ID автора которому пренадлежит файл")
    private int authorId;

    @Column(name = "file_type_id")
    @ApiModelProperty(value = "ID типа файла")
    private int fileTypeId;

    public File() {
    }

    public File(String fileName, String trackName, int placements, int authorId, int fileTypeId) {
        this.fileName = fileName;
        this.trackName = trackName;
        this.placements = placements;
        this.authorId = authorId;
        this.fileTypeId = fileTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getPlacements() {
        return placements;
    }

    public void setPlacements(int placements) {
        this.placements = placements;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(int fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", trackName='" + trackName + '\'' +
                ", placements=" + placements +
                ", authorId=" + authorId +
                ", fileTypeId=" + fileTypeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id == file.id && placements == file.placements && authorId == file.authorId && fileTypeId == file.fileTypeId && Objects.equals(fileName, file.fileName) && Objects.equals(trackName, file.trackName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, trackName, placements, authorId, fileTypeId);
    }
}
