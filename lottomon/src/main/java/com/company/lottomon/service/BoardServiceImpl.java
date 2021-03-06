package com.company.lottomon.service;

import java.util.List;

import com.company.lottomon.model.BoardComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.lottomon.mapper.BoardDAO;
import com.company.lottomon.model.Board;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int selectListCount(Board board) {
		return boardDAO.selectListCount(board);
	}

	@Override
	public List<Board> selectList(Board board) {
		return boardDAO.selectList(board);
	}

	@Override
	public List<Board> selectPostBoard(Board board) {
		return boardDAO.selectPostBoard(board);
	}

	@Override
	public List<Board> selectPostBoardDetail(Board board) { return boardDAO.selectPostBoardDetail(board); }

	@Override
	public int insertBoardContent(Board board) { return boardDAO.insertBoardContent(board); }

	@Override
	public int deleteBoardContent(int seq) { return boardDAO.deleteBoardContent(seq); }

	@Override
	public int updateBoardViewUp(int seq) { return boardDAO.updateBoardViewUp(seq); }

	@Override
	public int insertBoardCommentContent(BoardComment boardComment) { return boardDAO.insertBoardCommentContent(boardComment); }

	@Override
	public int editBoardCommentContent(BoardComment boardComment) { return boardDAO.editBoardCommentContent(boardComment); }

	@Override
	public int deleteBoardCommentContent(int seq) { return boardDAO.deleteBoardCommentContent(seq); }
}
