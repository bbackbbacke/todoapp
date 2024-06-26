package com.sparta.individualassignment.javaassignment_individual.controller;

import com.sparta.individualassignment.javaassignment_individual.dto.CommentRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.CommentResponseDto;
import com.sparta.individualassignment.javaassignment_individual.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 등록
    @PostMapping("/comments")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    // 댓글 수정
    @PutMapping("/comments/{comment_id}")
    public CommentResponseDto modifyComment(@PathVariable Long comment_id, @RequestBody CommentRequestDto requestDto) {
        return commentService.modifyComment(comment_id, requestDto);
    }

    //일정 삭제
    @DeleteMapping("/comments/{comment_id}") //상태코드 반환
    public ResponseEntity<String> delete(@PathVariable Long comment_id, @RequestBody CommentRequestDto requestDto) {
        commentService.deleteComment(comment_id, requestDto);
        return new ResponseEntity<>("삭제를 성공했습니다.", HttpStatus.OK);
    }


}
