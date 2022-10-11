import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import Header from '../components/Header';
import Footer from '../components/Footer';
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
  /* border: 1px solid red; */
`;
const FormBox = styled.div`
  width: 400px;
  height: 500px;
  padding-top: 30px;
  padding-left: 30px;
  border-radius: 3px;
  border: none;
  border: 1px solid hsl(210, 8%, 75%);
  /* display: flex;
  flex-direction: column; */
`;
const TitleZone = styled.div`
  width: 80%;
  height: 10%;
  padding: 10px 20px;
`;
const InputZone = styled(TitleZone)`
  height: 55%;
  display: flex;
  flex-direction: column;
  /* border: 1px solid red; */
`;

const FormInfo = styled(TitleZone)`
  /* border: 1px solid blue; */
  width: 90%;
  display: flex;
  align-items: center;
  justify-content: space-around;
`;
const FormTitle = styled.div`
  width: 20%;
  height: 25px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
`;
const InputBox = styled.input`
  width: 80%;
  height: 25px;
  padding: 2.5px;
  border-radius: 3px;
  border: none;
  outline: 1px solid hsl(210, 8%, 75%);
`;
const BtnZone = styled(TitleZone)`
  height: 20%;
  display: flex;
  justify-content: center;
`;

const JoinButton = styled.input`
  width: 150px;
  height: 50px;
  padding: 0.5em 1em;
  text-shadow: 1px 1px 3px #666666;
  color: white;
  margin: 1em;
  border-radius: 25px;
  border: none;
  background: #7d45a8;
  display: flex;
  justify-content: center;
  align-items: center;
  outline: 1px solid #7d45a8;
  &:hover {
    color: #f0be29;
    cursor: pointer;
  }
`;

function RegisterInfo() {
  const [username, setUserName] = useState('');
  const [email, setEmail] = useState('');
  const [pw, setPw] = useState('');
  const [phone, setPhone] = useState('');
  const [payment, setPayment] = useState('');
  const navigate = useNavigate();

  let Named = (e) => setUserName(e.target.value);
  let Email = (e) => setEmail(e.target.value);
  let Pass = (e) => setPw(e.target.value);
  let Phone = (e) => setPhone(e.target.value);
  let Pay = (e) => setPayment(e.target.value);
  //   const handleClick = (event) => {
  //     // event.preventDefault();
  //     // setUserName(event.target.username)
  //     console.log(event.target);
  //   };

  const JoinFetch = () => {
    let members = {
      username: `${username}`,
      email: `${email}`,
      password: `${pw}`,
      phoneNumber: `${phone}`,
      profileImageUrl: 'image.come',
      paymentMethod: `${payment}`,
    };

    fetch(process.env.REACT_APP_TEST_REGISTER_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(members),
    })
      .then((res) => {
        if (res.status === 201) {
          //throw new Error('fail to fetch');
          res.json();
        }
      })
      .then((res) => console.log(res))
      .then((data) => console.log('성공:', data))
      .catch((err) => console.error('실패:', err));
    // SignUp();
  };

  const onSubmit = (e) => {
    e.preventDefault();
    // setUserName(e.target.name.value);
    // setEmail(e.target.emailId.value);
    // setPw(e.target.pw.value);
    // setPhone(e.target.phone.value);
    // setPayment(e.target.payment.value);

    JoinFetch();
    SignUp();
  };
  const SignUp = () => {
    navigate('/login');
  };

  return (
    <>
      <Header />
      <PaddingBox />
      <Background>
        <form onSubmit={onSubmit}>
          <FormBox>
            <TitleZone>
              <font.H1>회원가입정보</font.H1>
            </TitleZone>
            <InputZone>
              <FormInfo>
                <FormTitle>
                  <font.H4>이름</font.H4>
                </FormTitle>
                <InputBox
                  type="text"
                  name="name"
                  placeholder="name"
                  onChange={Named}
                ></InputBox>
              </FormInfo>
              <FormInfo>
                <FormTitle>
                  <font.H4>이메일</font.H4>
                </FormTitle>
                <InputBox
                  type="text"
                  name="emailId"
                  placeholder="email"
                  onChange={Email}
                ></InputBox>
              </FormInfo>
              <FormInfo>
                <FormTitle>
                  <font.H4>비밀번호</font.H4>
                </FormTitle>
                <InputBox
                  type="password"
                  name="pw"
                  placeholder="password"
                  onChange={Pass}
                ></InputBox>
              </FormInfo>
              <FormInfo>
                <FormTitle>
                  <font.H4>연락처</font.H4>
                </FormTitle>
                <InputBox
                  type="tel"
                  name="phone"
                  placeholder="phone"
                  onChange={Phone}
                ></InputBox>
              </FormInfo>
              <FormInfo>
                <FormTitle>
                  <font.H4>결제수단</font.H4>
                </FormTitle>
                <InputBox
                  type="text"
                  name="payment"
                  placeholder="payment"
                  onChange={Pay}
                ></InputBox>
              </FormInfo>
            </InputZone>
            {/* <JoinButton type="submit" onClick={handleClick}>
                가입하기
              </JoinButton> */}
            <BtnZone>
              <JoinButton type="submit" />
            </BtnZone>
          </FormBox>
        </form>
        <Footer />
      </Background>
    </>
  );
}

export default RegisterInfo;
