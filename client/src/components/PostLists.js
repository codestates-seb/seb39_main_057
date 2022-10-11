import React from 'react';
import { useEffect, useState } from 'react';
import { Routes, Route, Link, useNavigate, useParams } from 'react-router-dom';
import styled from 'styled-components';
import axios from 'axios';

let PostList = styled.div`
  margin-top: 1%;
  width: 800px;
  height: auto;
  /* border: 1px solid pink; */
  /* display: flex; */
  /* justify-content: space-around; */
  /* flex-direction: column; */
  /* align-items: center; */
`;
let PostHeadTitle = styled(PostList)`
  margin-top: 1rem;
  font-weight: 700;
  display: flex;
  justify-content: space-around;
  align-items: center;
  /* border: 1px solid blue; */
`;
let PostHead = styled(PostHeadTitle)`
  font-weight: 500;
  &:hover {
    /* border:2px solid red; */
    cursor: pointer;
  }
`;
let HeadLine = styled.div`
  width: 25%;
  height: auto;
  border-bottom: 1px solid gray;
  text-align: center;
`;
let ContentsBox = styled(PostHeadTitle)`
  margin-top: 2px;
  font-weight: 400;
  border-bottom: 1px solid gray;
  text-align: center;
`;
function elapsedTime(date) {
    const end = new Date(date);// 마감 시간
    const now = new Date(); // 현재 시간
    
    const diff = (end - now); // 차감 시간
   
    const times = [
      {time: "분", milliSeconds: 1000 * 60},
      {time: "시간", milliSeconds: 1000 * 60 * 60},
      {time: "일", milliSeconds: 1000 * 60 * 60 * 24},
      {time: "개월", milliSeconds: 1000 * 60 * 60 * 24 * 30},
      {time: "년", milliSeconds: 1000 * 60 * 60 * 24 * 365},
    ].reverse();
    
    // 년 단위부터 알맞는 단위 찾기
    for (const value of times) {
      const betweenTime = Math.floor(diff / value.milliSeconds);
          
      // 큰 단위는 0보다 작은 소수 단위 나옴
      if (betweenTime > 0) {
        return `${betweenTime}${value.time} 전`;
      }
    }
    
    // 모든 단위가 맞지 않을 시
    return "곧 마감";
  }
  function getDistance(lat1, lon1, lat2, lon2) {
    if ((lat1 == lat2) && (lon1 == lon2))
        return 0;

    var radLat1 = Math.PI * lat1 / 180;
    var radLat2 = Math.PI * lat2 / 180;
    var theta = lon1 - lon2;
    var radTheta = Math.PI * theta / 180;
    var dist = Math.sin(radLat1) * Math.sin(radLat2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.cos(radTheta);
    if (dist > 1)
        dist = 1;

    dist = Math.acos(dist);
    dist = dist * 180 / Math.PI;
    dist = dist * 60 * 1.1515 * 1.609344 * 1000;
    if (dist < 100) dist = Math.round(dist / 10) * 10;
    else dist = Math.round(dist / 100) * 100;

    return dist;
}


function PostLists(){
    let [contents, setContents] = useState([]);
    let [users, setUsers] = useState([]);
    let navigate = useNavigate();
    let {id} = useParams()
    let [limit, setLimit] = useState('');

    
    useEffect(()=>{
        axios.get(process.env.REACT_APP_TEST_ALLITEMS_URL).then((res)=>{
            let copy = [...res.data];
            // console.log(copy);
            setContents(copy)
        })
        .catch(()=>{
          console.log('실패함')
        })
     },[])
   
     useEffect(()=>{
        axios.get(process.env.REACT_APP_TEST_ALLMEMBERS_URL).then((res)=>{
            let copy = [...res.data];
            // console.log(copy);
            setUsers(copy)
            // console.log(res.data)
        })
        .catch(()=>{
          console.log('실패함')
        })
     },[])
    return(
        <PostList>
        <PostHeadTitle>
            <HeadLine>주문매장</HeadLine>
            <HeadLine>공구마</HeadLine>
            <HeadLine>모집인원</HeadLine>
            <HeadLine>거리</HeadLine>
            <HeadLine>마감시간</HeadLine>
        </PostHeadTitle>
        {
            id === undefined
            ?contents.map((a, i)=>{
                const detail = a.itemId; //수정 id를 itemId로 
                // const detail = a.id; //수정 id를 itemId로 
                const user = users.find((el)=>{return el.memberId===a.memberId});
                const lat2 = a.pickupLocation.latitude;
                const lon2 = a.pickupLocation.longitude;
                return(
                    <PostHead key={i} onClick={()=>{
                        navigate(`/post/${detail}`)
                    }}>
                        <ContentsBox>{a.restaurantName}</ContentsBox>
                        <ContentsBox>{user?.username}</ContentsBox>
                        <ContentsBox>{a.recruit}명</ContentsBox>
                        <ContentsBox>{getDistance(33.5563, 126.79581, lat2, lon2)}미터</ContentsBox>
                        <ContentsBox>{elapsedTime(a.deadline)}</ContentsBox>
                    </PostHead>
                )
            })
            :contents.filter((el)=>
                el.foodCategoryId == id).map((a, i)=>{
                const detail = a.itemId; //detail은 게시판 글 클릭시 해당 글의 itemId입니다.
                const user = users.find((el)=>{return el.memberId===a.memberId});
                const lat2 = a.pickupLocation.latitude;
                const lon2 = a.pickupLocation.longitude;
                return(
                    <PostHead key={i} onClick={()=>{
                        navigate(`/post/${detail}`)
                    }}>
                        <ContentsBox>{a.restaurantName}</ContentsBox>
                        <ContentsBox>{user?.username}</ContentsBox>
                        <ContentsBox>{a.recruit}명</ContentsBox>
                        <ContentsBox>{getDistance(33.481510, 126.508923, lat2, lon2)}미터</ContentsBox>
                        <ContentsBox>{elapsedTime(a.deadline)}</ContentsBox>
                    </PostHead>
                )
            })
        }
        </PostList>
    ) 
};

export default PostLists;
