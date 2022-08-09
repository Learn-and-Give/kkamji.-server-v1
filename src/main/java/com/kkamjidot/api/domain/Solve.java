package com.kkamjidot.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "solve")
public class Solve {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solve_id", nullable = false)
    private Long id;

    @Column(name = "solve_submitted_answer", columnDefinition = "TEXT")
    private String solveSubmittedAnswer;

    @Column(name = "solve_is_correct", nullable = false)
    private Boolean solveIsCorrect = false;

    @Column(name = "created_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Instant createdDate;

    @Column(name = "modified_date", columnDefinition = "timestamp null on update CURRENT_TIMESTAMP")
    private Instant modifiedDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}