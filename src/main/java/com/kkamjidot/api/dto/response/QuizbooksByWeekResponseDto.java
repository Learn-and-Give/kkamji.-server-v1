package com.kkamjidot.api.dto.response;

import com.kkamjidot.api.domain.Quizbook;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

//@ApiModel(value = "주차별 문제집 모음 조회 응답")
@Getter
public class QuizbooksByWeekResponseDto {
    @ApiModelProperty(value = "문제집 ID", example = "1", required = true)
    private Long quizbookId;

    @ApiModelProperty(value = "문제집 제목", example = "문제집1 제목", required = true)
    private String quizbookTitle;

    @ApiModelProperty(value = "문제집 설명", example = "문제집1 설명", required = true)
    private String quizbookDescription;

    @ApiModelProperty(value = "문제 수", example = "10", required = true)
    private Integer numOfQuizzes;

    @ApiModelProperty(value = "문제집 주차", example = "1", required = true)
    private Integer quizbookWeek;

    @ApiModelProperty(value = "제출 회원 이름", example = "홍길동", required = true)
    private String submitUserName;

    public QuizbooksByWeekResponseDto(Quizbook quizbook) {
        this.quizbookId = quizbook.getId();
        this.quizbookTitle = quizbook.getQuizbookTitle();
        this.quizbookDescription = quizbook.getQuizbookDescription();
        this.numOfQuizzes = quizbook.getNumberOfQuizs();
        this.quizbookWeek = quizbook.getQuizbookWeek();
        this.submitUserName = quizbook.getMember().getMemberName();
    }
}
