package com.kkamjidot.api.domain;

import com.kkamjidot.api.dto.response.QuizbookResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "quizbook")
public class Quizbook {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizbook_id", nullable = false)
    private Long id;

    @Column(name = "quizbook_title")
    private String quizbookTitle;

    @Column(name = "quizbook_description", columnDefinition = "TEXT")
    private String quizbookDescription;

    @Column(name = "quizbook_submitted_date")
    private Instant quizbookSubmittedDate;

    @Column(name = "quizbook_deleted_date")
    private Instant quizbookDeletedDate;

    @Column(name = "created_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Instant createdDate;

    @Column(name = "modified_date", columnDefinition = "timestamp null on update CURRENT_TIMESTAMP")
    private Instant modifiedDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @OneToMany(mappedBy = "quizbook")
    private Set<Quiz> quizzes = new LinkedHashSet<>();

    public int getNumberOfQuizzes() {
        return this.quizzes.size();
    }

    public String getQuizbookMemberName() {
        return this.member.getMemberName();
    }

    public QuizbookResponseDto ofQuizbookResponseDto() {
        return QuizbookResponseDto.builder()
                .quizbookId(this.getId())
                .quizbookTitle(this.getQuizbookTitle())
                .quizbookDescription(this.getQuizbookDescription())
                .numOfQuizzes(this.getNumberOfQuizzes())
                .submitUserName(this.getQuizbookMemberName())
                .build();
    }
}