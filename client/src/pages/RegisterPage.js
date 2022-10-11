import React, { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import Header from '../components/Header';
import Footer from '../components/Footer';
import font from '../styles/font';

let PaddingBox = styled.div`
  height: 60px;
`;
const Background = styled.div`
  width: 100%;
  height: auto;
  margin-top: 50px;
  display: flex;
  justify-content: center;
  /* border: 1px solid red; */
`;
const FormBox = styled.div`
  width: 400px;
  height: 500px;
  padding-left: 30px;
  padding-top: 30px;
  border-radius: 3px;
  border: none;
  border: 1px solid hsl(210, 8%, 75%);
`;
const TitleZone = styled.div`
  width: 80%;
  height: 15%;
  padding: 10px 20px;
  /* border: 1px solid blue; */
`;

const FormBoxInfo = styled.div`
  width: 80%;
  height: 10%;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  /* border: 1px solid red; */
`;
const CheckZone = styled.div`
  width: 15%;
  height: 20px;
  /* border: 1px solid blue; */
  display: flex;
  justify-content: center;
`;
const TextZone = styled.div`
  width: 85%;
  height: 20px;
  display: flex;
  align-items: center;
`;
const ButtonZone = styled(TitleZone)`
  height: 15%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
`;
const SubmitButton = styled.button`
  width: 150px;
  height: 50px;
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
  border: none;
  outline: 1px solid #7d45a8;
  &:hover {
    color: #f0be29;
    font-weight: 700;
    cursor: pointer;
  }
`;

const RegisterPage = () => {
  const CheckData = [
    { id: 0, title: '[필수] 만 14세 이상입니다.' },
    { id: 1, title: '[필수] 만 14세 이상입니다.' },
    { id: 2, title: '[필수] 만 14세 이상입니다.' },
    { id: 3, title: '[선택] 마케팅 정보 수신에 대한 동의' },
  ];
  const [checkItems, setCheckItems] = useState([]);
  const navigate = useNavigate();

  const handleSingleCheck = (checked, id) => {
    if (checked) {
      setCheckItems((prev) => [...prev, id]);
    } else {
      setCheckItems(checkItems.filter((el) => el !== id));
    }
  };

  // 체크박스 전체 선택
  const handleAllCheck = (checked) => {
    if (checked) {
      // 전체 선택 클릭 시 데이터의 모든 아이템(id)를 담은 배열로 checkItems 상태 업데이트
      const idArray = [];
      CheckData.forEach((el) => idArray.push(el.id));
      setCheckItems(idArray);
    } else {
      // 전체 선택 해제 시 checkItems 를 빈 배열로 상태 업데이트
      setCheckItems([]);
    }
  };
  return (
    <>
      <Header />
      <PaddingBox />
      <Background>
        <FormBox>
          <TitleZone>
            <font.H1>회원가입</font.H1>
            <font.H4>
              환영합니다! 호박공구마 서비스 이용약관에 동의해주세요.
            </font.H4>
          </TitleZone>
          <FormBoxInfo>
            <CheckZone>
              <input
                type="checkbox"
                name="select-all"
                onChange={(e) => handleAllCheck(e.target.checked)}
                checked={checkItems.length === CheckData.length ? true : false}
              />
            </CheckZone>
            <TextZone>
              <font.BoldP>모두동의합니다.</font.BoldP>
            </TextZone>
          </FormBoxInfo>

          {CheckData?.map((CheckData, key) => (
            <FormBoxInfo key={key}>
              <CheckZone>
                <input
                  type="checkbox"
                  name={`${CheckData.id}`}
                  onChange={(e) =>
                    handleSingleCheck(e.target.checked, CheckData.id)
                  }
                  checked={checkItems.includes(CheckData.id) ? true : false}
                />
              </CheckZone>
              <TextZone>
                <font.P>{CheckData.title}</font.P>
              </TextZone>
            </FormBoxInfo>
          ))}
          <ButtonZone>
            <SubmitButton onClick={() => navigate('/regiInfo')}>
              <font.Body1>동의하고 진행하기</font.Body1>
            </SubmitButton>
          </ButtonZone>
        </FormBox>
      </Background>
      <Footer />
    </>
  );
};

export default RegisterPage;
