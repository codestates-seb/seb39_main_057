import { useEffect, useState } from 'react';
import styled from 'styled-components';
import Header from '../components/Header';
import Footer from '../components/Footer';
import PostLists from '../components/PostLists';
import FilterBar from '../components/FilterBar';
import { Map, MapMarker } from 'react-kakao-maps-sdk';
import axios from 'axios';

let PaddingBox = styled.div`
  height: 60px;
`;
let Body = styled.div`
  width: 96%;
  margin: 0 auto;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
`;
let Describe = styled.div`
  width: 85%;
  height: 80px;
  margin-top: 10px;
  margin-bottom: 5px;
  font-weight: 800;
  text-align: center;
  background-image: url('./background.jpeg');
  /* background-size: cover; */
  /* background-position: center; */
  display: flex;
  justify-content: center;
  border: 1px solid gray;
  border-radius: 10px;
  > div {
    width: 100px;
    height: 80px;
    border: 1px solid red;
    margin-right: 15px;
  }
`;
let MapImg = styled.div`
  width: 85%;
  height: 300px;
  margin-top: 1%;
  border: 1px solid gray;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function PostListPage() {
  const [contents, setContents] = useState([]);

  useEffect(()=>{
    axios.get(process.env.REACT_APP_TEST_ALLITEMS_URL).then((res)=>{
        let copy = [...res.data];
        // console.log(copy);
        setContents(copy);
        // console.log(choice)

    })
    .catch(()=>{
      console.log('실패함')
    })
 },[])



  return (
    <>
      <Header />
      <PaddingBox />
      <Body>
        <Describe>
          {/* <div>
            <img src="url('./logo192.png')" />
          </div> */}
          <br></br>호박공구마는 배달건당 주문량을 늘려 탄소절감과 고객비용부담
          완화를 통해 <br></br>더 나은 세상을 만들기 위한 배달비공유
          사이트입니다.
        </Describe>
        <MapImg>
          <Map
            center={{ lat: 33.481510, lng: 126.508923}}
            style={{ width: '98%', height: '98%' }}
            level={3} // 지도의 확대 레벨
          >
            {/* {positions.map((position, index) => (
          <MapMarker
            key={`${position.title}-${position.latlng}`}
            position={position.latlng} // 마커를 표시할 위치
            image={{
              src: "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png", // 마커이미지의 주소입니다
              size: {
                width: 24,
                height: 35
              }, // 마커이미지의 크기입니다
            }}
            title={position.title} // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          />
      ))} */}
          {contents.map((position, index) => (
              <MapMarker
                key={`${position?.pickupLocation?.nameOfPlace}-${position?.pickupLocation?.latitude}`}
                position={{"lat":position?.pickupLocation?.latitude, "lng": position?.pickupLocation?.longitude} } // 마커를 표시할 위치
                image={{
                  src: "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png", // 마커이미지의 주소입니다
                  size: {
                    width: 24,
                    height: 35
                  }, // 마커이미지의 크기입니다
                }}
                title={position.title} // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
              />
          ))}
          </Map>
        </MapImg>
        <FilterBar />
        <PostLists />
        <Footer />
      </Body>
    </>
  );
}

export default PostListPage;
