import React, { Component } from 'react';
import axios from 'axios';
import { Card, Table, ButtonGroup, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import MyToast from './MyToast';

export default class VoitureListe extends Component {

  constructor(props) {
    super(props);
    this.state = {
      voitures: [],
      show: false
    };
  }

  // 🔹 Charger les voitures au montage
  componentDidMount() {
    axios.get("http://localhost:8080/api/voitures")
      .then(response => response.data)
      .then((data) => {
        this.setState({ voitures: data });
      })
      .catch(error => {
        console.error("Erreur chargement voitures", error);
      });
  }

  // 🔹 deleting
  deleteVoiture = (voitureId) => {
    axios.delete("http://localhost:8080/api/voitures" + voitureId)
      .then(response => {
        if (response.data != null) {
          this.setState({
            voitures: this.state.voitures.filter(voiture => voiture.id !== voitureId),
            show: true
          });
          setTimeout(() => this.setState({ show: false }), 3000);
        } else {
          this.setState({ show: false });
        }
      })
      .catch(error => {
        console.error("Erreur lors de la suppression de la voiture", error);
        this.setState({ show: false });
      });
  };

  render() {
    return (
      <div>
        {/* 🔹 Toast rouge pour suppression */}
        <div style={{ display: this.state.show ? "block" : "none" }}>
          <MyToast children={{ show: this.state.show, message: "Voiture supprimée avec succès.", type: "danger" }} />
        </div>

        <Card className="border border-dark bg-dark text-white">
          <Card.Header>Liste des Voitures</Card.Header>
          <Card.Body>
            <Table bordered hover striped variant="dark">
              <thead>
                <tr>
                  <th>Marque</th>
                  <th>Modèle</th>
                  <th>Couleur</th>
                  <th>Immatricule</th>
                  <th>Année</th>
                  <th>Prix</th>
                  <th>Actions</th>
                </tr>
              </thead>

              <tbody>
                {
                  this.state.voitures.length === 0 ?
                    <tr align="center">
                      <td colSpan="7">Aucune voiture disponible</td>
                    </tr>
                  :
                    this.state.voitures.map(voiture => (
                      <tr key={voiture.id}>
                        <td>{voiture.marque}</td>
                        <td>{voiture.modele}</td>
                        <td>{voiture.couleur}</td>
                        <td>{voiture.immatricule}</td>
                        <td>{voiture.annee}</td>
                        <td>{voiture.prix}</td>
                        <td>
                          <ButtonGroup>
                            <Button size="sm" variant="outline-primary">
                              <FontAwesomeIcon icon={faEdit} />
                            </Button>{' '}
                            <Button size="sm" variant="outline-danger"
                              onClick={this.deleteVoiture.bind(this, voiture.id)}>
                              <FontAwesomeIcon icon={faTrash} />
                            </Button>
                          </ButtonGroup>
                        </td>
                      </tr>
                    ))
                }
              </tbody>
            </Table>
          </Card.Body>
        </Card>
      </div>
    );
  }
}
