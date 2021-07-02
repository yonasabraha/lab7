package edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transcriptId;

    @NotBlank(message="Degree title is a required field")
    private String degreeTitle;

    public Transcript(@NotBlank(message = "Degree title is a required field") String degreeTitle, Student student) {
        this.degreeTitle = degreeTitle;
        this.student = student;
    }

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Transcript() {}

    @OneToOne(mappedBy = "transcript")
    private Student student;

    public long getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(long transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "degreeTitle='" + degreeTitle + '\'' +
                '}';
    }
}
