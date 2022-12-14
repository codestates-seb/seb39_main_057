import React, { useState, useEffect } from 'react';
import Header from '../components/Header';
import Footer from '../components/Footer';
import styled from 'styled-components';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import font from '../styles/font';
import data from '../data';

let PaddingBox = styled.div`
  height: 60px;
`;
const Background = styled.div`
  width: 100%;
  height: auto;
  margin-top: 50px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;
const ContentsArea = styled.div`
  /* border: 1px solid yellow; */
  width: 53%;
  height: 90%;
  padding: 10px 20px;
  display: flex;
  flex-direction: column;
  /* align-items: center; */
  justify-content: space-between;
`;
const AddressBox = styled(ContentsArea)`
  width: 90%;
  height: 50%;
  padding: 15px;
  border-radius: 3px;
  border: none;
  outline: 1px solid hsl(210, 8%, 75%);
`;
const WriteInfo = styled(AddressBox)`
  height: 400px;
  padding: 0px 15px;
  border-radius: 3px;
  border: none;
  outline: 1px solid hsl(210, 8%, 75%);
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
`;
const WriteInfoChild = styled.div`
  /* border: 1px solid blue; */
  width: 98%;
  height: 25px;
  display: flex;
  justify-content: space-around;
  align-items: center;
`;
const Title = styled.div`
  width: 15%;
  height: 100%;
  display: flex;
  align-items: center;
  /* border: 1px solid red; */
`;
const Content = styled.div`
  width: 80%;
  height: 100%;
  display: flex;
  justify-content: flex-start;
  > div {
    height: 100%;
    margin-left: 5px;
    color: gray;
    display: flex;
    align-items: center;
    font-size: 12px;
  }
  > select {
    width: 90%;
    height: 100%;
    border-radius: 3px;
    resize: none;
    border: none;
    outline: 1px solid hsl(210, 8%, 75%);
    &:focus select option {
      background-color: white;
    }
  }
`;
const AddBtn = styled.button`
  width: 110px;
  height: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
  text-shadow: 1px 1px 3px #666666;
  color: white;
  margin: 1em;
  padding: 0.5em 1em;
  border-radius: 25px;
  background: #7d45a8;
  text-decoration: none;
  /* border: 1px solid solid #7e30d1; */
  border: none;
  outline: 1px solid #7d45a8;
  &:hover {
    color: #f0be29;
    cursor: pointer;
  }
`;
const InputBox = styled.input`
  /* width: 450px; */
  width: 90%;
  height: 18px;
  padding: 4.5px;
  border-radius: 3px;
  border: none;
  outline: 1px solid hsl(210, 8%, 75%);
`;
const LimitInput = styled(InputBox)`
  width: 43%;
`;
const TextareaBox = styled.textarea`
  width: 90%;
  height: 40px;
  overflow: visible;
  padding: 4px;
  border-radius: 3px;
  resize: none;
  border: none;
  outline: 1px solid hsl(210, 8%, 75%);
`;
const BtnZone = styled.div`
  width: 500px;
  height: 15%;
  display: flex;
  justify-content: center;
`;
const SubmitBtn = styled.input`
  width: 110px;
  height: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
  text-shadow: 1px 1px 3px #666666;
  color: white;
  margin: 1em;
  padding: 0.25em 1em;
  border-radius: 28px;
  background: #7d45a8;
  text-decoration: none;
  /* border: 1px solid solid #7e30d1; */
  border: none;
  outline: 1px solid #7d45a8;
  &:hover {
    color: #f0be29;
    cursor: pointer;
  }
`;

function WritePage() {
  let navigate = useNavigate();
  let [category, setCategory] = useState('');
  let [menuUrl, setUrl] = useState('');
  let [participate, setParticipate] = useState('');
  let [deadline, setDeadLine] = useState('');
  let [notice, setNotice] = useState('');

  let NowCategory = (e) => setCategory(e.target.value);
  let MenuURL = (e) => setUrl(e.target.value);
  let Recruit = (e) => setParticipate(e.target.value);
  let Dday = (e) => setDeadLine(e.target.value);
  let Comment = (e) => setNotice(e.target.value);

  let LimitDate = new Date();
  LimitDate.setMinutes(LimitDate.getMinutes() + deadline / 1);
  console.log(LimitDate);

  const LimitTime = (a) => {
    let today = new Date();
    let year = today.getFullYear(); // ??????
    let month = today.getMonth() + 1; // ???
    let date = today.getDate(); // ??????
    let hours = today.getHours(); // ???
    let minutes = today.setMinutes(today.getMinutes() + a / 1); // ???
    let seconds = today.getSeconds(); // ???
    console.log(
      year +
        '-' +
        month +
        '-' +
        date +
        ' ' +
        hours +
        ':' +
        minutes +
        ':' +
        seconds,
    );
  };

  const SubmitWrite = () => {
    let posts = {
      "memberId": 1, 
      "title": "?????????????????????",
      "foodCategoryId": `${category}`,
      "deadline": `${deadline}`,
      "recruit": `${participate}`,
      "pickupLocation" : {
        "nameOfPlace": "??????????????????",
        "korAddress": "????????? ?????????",
        "addressDetail": "101??? 101???",
        "type": 1,
        "latitude": 33.481510,
        "longitude": 126.508923
    },
    "restaurantName": "?????????????????????",
    "restaurantUrl": `${menuUrl}`,
    "body": `${notice}`,
    "imageUrl": {
        "url": "imageurl/url/image.jpg",
        "type": 1
    }
    };

    return axios
    .post(process.env.REACT_APP_TEST_MAKE_URL, posts)
    .then((res) => {
      console.log(res.data)
      navigate(`/post/${res.data.itemId}`)
    })
    .catch((err)=>{
      console.log(err.response.data)
    });
  }

  const onSubmit = (e) => {
    e.preventDefault();
    SubmitWrite();
  };

  return (
    <>
      <Header />
      <PaddingBox />
      <Background>
        <ContentsArea>
          <AddressBox>
            <font.H1>????????? ??????</font.H1>
            <div>????????? </div>
            <p>????????????????????? ????????? ????????? ?????????, 101??? </p>
            <p>010-0707-8282</p>
            <p>??? ???</p>
            <div>
              <button>??????</button>
              <button>??????</button>
            </div>
          </AddressBox>
          <BtnZone>
            <AddBtn>+???????????????</AddBtn>
          </BtnZone>
          <form onSubmit={onSubmit}>
            <WriteInfo>
              <WriteInfoChild>
                <Title>
                  <font.H4>????????????</font.H4>
                </Title>
                <Content>
                  <select onChange={NowCategory}>
                    <option value="??????">--??????--</option>
                    <option value="1">1?????? ??????</option>
                    <option value="2">???????????????</option>
                    <option value="3">??????</option>
                    <option value="4">??????/??????</option>
                    <option value="5">??????</option>
                    <option value="6">??????</option>
                    <option value="7">??????/?????????</option>
                    <option value="8">??????/??????</option>
                    <option value="9">??????</option>
                    <option value="10">??????</option>
                    <option value="11">??????/?????????</option>
                    <option value="12">?????????/??????</option>
                  </select>
                </Content>
              </WriteInfoChild>
              <WriteInfoChild>
                <Title>
                  <font.H4>URL</font.H4>
                </Title>
                <Content>
                  <InputBox
                    placeholder="?????????????????? ???????????? ??????????????? url??? ?????????????????? ?????????"
                    name="url"
                    onChange={MenuURL}
                  ></InputBox>
                </Content>
              </WriteInfoChild>
              <WriteInfoChild>
                <Title>
                  <font.H4>????????????</font.H4>
                </Title>
                <Content>
                  <LimitInput
                    type="number"
                    name="number"
                    step="1"
                    min="1"
                    max="3"
                    onChange={Recruit}
                  ></LimitInput>
                  <div>???????????? ????????? ??????????????????. ?????? 3???</div>
                </Content>
              </WriteInfoChild>
              <WriteInfoChild>
                <Title>
                  <font.H4>????????????</font.H4>
                </Title>
                <Content>
                  <LimitInput
                    // type="time"
                    name="deadline"
                    step="30"
                    min="0"
                    max="120"
                    onChange={Dday}
                  ></LimitInput>
                  <div>30??? ????????? ????????? ??? ????????????. ?????? 2??????</div>
                </Content>
              </WriteInfoChild>
              <WriteInfoChild>
                <Title>
                  <font.H4>????????????</font.H4>
                </Title>
                <Content>
                  <TextareaBox
                    placeholder="??????????????? ??????????????? ??????????????????."
                    name="notice"
                    onChange={Comment}
                  ></TextareaBox>
                </Content>
              </WriteInfoChild>
            </WriteInfo>
            <BtnZone>
              <SubmitBtn type="submit" value="????????????" />
            </BtnZone>
          </form>
        </ContentsArea>
      </Background>
      <Footer />
    </>
  );
}

export default WritePage;
