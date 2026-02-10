import React from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';
import { Link } from 'react-router-dom';


class NavigationBar extends React.Component {
  render() {
    return (
      <Navbar bg="dark" variant="dark" expand="lg">
        <Container>

          {/* Logo */}
          <Navbar.Brand as={Link} to="/">
            <img
              src="../images/logocar.webp"
              width="30"
              height="30"
              alt="logo"
            />
          </Navbar.Brand>

          {/* Bouton Hamburger */}
          <Navbar.Toggle aria-controls="basic-navbar-nav" />

          {/* Contenu caché */}
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link as={Link} to="/add">Ajouter Voiture</Nav.Link>
              <Nav.Link as={Link} to="/list">Liste des Voitures</Nav.Link>
            </Nav>
          </Navbar.Collapse>

        </Container>
      </Navbar>
    );
  }
}

export default NavigationBar;
