import React from 'react';
import './App.css';
import { Container, Row, Col } from 'react-bootstrap';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import NavigationBar from './components/NavigationBar';
import Footer from './components/Footer';
import Bienvenue from './components/Bienvenue';
import Voiture from './components/Voiture';
import VoitureListe from './components/VoitureListe';

function App() {
  const marginTop = { marginTop: "20px" };

  return (
    <Router>
      <NavigationBar />

      <Container>
        <Row>
          <Col lg={12} style={marginTop}>
            <Routes>
              <Route path="/" element={<Bienvenue />} />
              <Route path="/add" element={<Voiture />} />
              <Route path="/list" element={<VoitureListe />} />
            </Routes>
          </Col>
        </Row>
      </Container>

      <Footer />
    </Router>
  );
}

export default App;
