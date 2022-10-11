import React from "react";
import { useState } from "react";
import styled from 'styled-components';
import commentData from '../commentdata'

let CommentBox = styled.div`
    width: 770px;
    height: auto;
    margin-top: 10px;
    padding-bottom: 1%;
    /* background-color: rgb(217 217 217); */
    color:black;
    border: 1px solid gray;
    border-radius: 10px;
    display: flex;
    flex-direction: column;
    justify-content: center;
`
let CommentLine = styled.div`
   width: 98%;
   height: 30px;
   /* border: 1px solid gray; */
   border-radius: 10px;
    margin-top: 1em;
   display: flex;
   justify-content: space-around;
`
let CommentItem = styled.div`
    width: 15%;
    height: 30px;
    font-weight: 600;
    /* border: 1px solid gray; */
    display: flex;
    justify-content: center;
    align-items: center;
`
let CommentInput = styled(CommentItem)`
    width: 85%;
    font-weight: 300;
    justify-content: flex-start;
    align-items: center;
`
let Input = styled.input`
  padding: 0.5em;
  /* margin: 0.5em; */
  color: ${props => props.inputColor || "palevioletred"};
  font-size: 15px;
  background: papayawhip;
  border: none;
  border-radius: 3px;
`;
let Button = styled.button`//로그인/회원가입버튼
    width: 80px;
    height: 30px;
  color: black;
  background-color: white;
  font-size: 15px;
  font-weight: 500;
  margin: 1em;
  padding: 0.25em 1em;
  border-radius: 10px;
  /* border: 2px solid palevioletred; */
  &:hover {
      color: red;
      cursor: pointer;
    }
`;
let NewComment = styled(CommentInput)`
    /* width: 15%;
    height: 30px;
    font-weight: 600; */
    /* border: 1px solid gray; */
    display: flex;
    justify-content: space-between;
    align-items: center;
`

function Comment(){
    let [comments, setComments] = useState(commentData); // 댓글데이터 불러오기 commentData.js
    let [text, setText] = useState("");
    let onChange = (e) => {
        setText(e.target.value);
      };

    return(
        <CommentBox>
            <CommentLine>
                <CommentItem>아이디</CommentItem>
                <NewComment>
                    <Input onChange={onChange} placeholder="주문내용에 대한 궁금한 내용을 남겨주세요" type="text" size="60" />
                    <Button onClick={()=>{
                        let arr = [...comments]
                        arr.push({
                            "userId" : "닉네임",
                            "comment" : text
                        })
                        setComments(arr)
                    }}>댓글</Button>
                </NewComment>
            </CommentLine>
            {
                comments.map((a, i)=>{
                    return(
                        <CommentLine key={i}>
                            <CommentItem>{comments[i].userId}</CommentItem>
                            <CommentInput>{comments[i].comment}</CommentInput>
                        </CommentLine>
                    )      
                })
            }
        </CommentBox>
    )
}

export default Comment;
