import React, { Component } from 'react';
import './../App.css';
import './../css/Register.css';
import Employeur from "../model/Employeur";
import EmployeurService from "../service/EmployeurService";
import {Redirect} from "react-router-dom";

let redirectStr = "";
export default class EmployeurRegister extends Component {
    constructor(props) {
        super(props);
       // let employeur = new Employeur()
        this.state = new Employeur();

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({[event.target.name]: event.target.value});
        console.log(redirectStr);
    }

    handleSubmit(event) {
        event.preventDefault();
        EmployeurService.post(this.state);
    }

    render(){
      
            return (
                <div className="formBox">
                    <h3>Register</h3>
                    <form onSubmit={this.handleSubmit}>
                        <label>
                            Nom:
                            <input type="text" name="nom" required value={this.state.nom} onChange={this.handleChange}/>
                        </label>
                        <label>
                            Prenom:
                            <input type="text" name="prenom" required value={this.state.prenom} onChange={this.handleChange}/>
                        </label>
                        <label>
                            Email:
                            <input type="email" name="email" required value={this.state.email} onChange={this.handleChange}/>
                        </label>
                        <label>
                            Mot de passe:
                            <input type="password" name="password" required value={this.state.password} onChange={this.handleChange}/>
                        </label>
                       
                        <label>
                            Matricule:
                            <input type="text" name="matricule" required value={this.state.matricule} onChange={this.handleChange} />
                        </label>
                        <label>
                            Telephone:
                            <input type="tel" name="telephone" required value={this.state.telephone} onChange={this.handleChange}/>
                        </label>
                       
                        
                        <input type="submit" value="Register"/>
                    </form>
                </div>
            );
        
    }
}