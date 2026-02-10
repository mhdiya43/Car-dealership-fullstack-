import React from 'react';
import { Card } from 'react-bootstrap';

class Bienvenue extends React.Component {
  render() {
    return (
      <Card bg="dark" text="white" className="text-center">
        <Card.Body>
          <Card.Title>Bienvenue au Magasin des Voitures</Card.Title>

          <blockquote className="blockquote mb-0">
            <p>
              Le meilleur de nos voitures est exposé près de chez vous
            </p>
            <footer className="blockquote-footer text-white">
              Master MIOLA
            </footer>
          </blockquote>
        </Card.Body>
      </Card>
    );
  }
}

export default Bienvenue;
