import React from 'react';
import styled from 'styled-components';
import font from '../styles/font';

const Background = styled.div`
  width: 100%;
  height: 100px;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  align-items: center;
  padding-bottom: 20px;
`;
const CopyFooter = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  align-items: center;
`;

function Footer() {
  return (
    <>
      <Background>
        <CopyFooter>
          <font.P>
            Copyright © 2022 PumkinSweet.co.,Ltd. All rights reserved.
          </font.P>
        </CopyFooter>
      </Background>
    </>
  );
}

export default Footer;
