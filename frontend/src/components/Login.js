import React, { Component } from 'react';
import User from '../model/User';
import './../App.css';
import './../css/Register.css';
import axios from 'axios'
import LoginService from '../service/LoginService'
import { withRouter } from 'react-router-dom';


const AUTH_TOKEN = 'auth_token';

export default class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: ' ',
            password: ' '

        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleChange(event) {
        this.setState({ [event.target.name]: event.target.value })
    }

    handleSubmit(event) {
    event.preventDefault();
        LoginService.login(this.state).then(()=>{ 
            this.props.history.push('/stages');
            window.location.reload();
        
        
        })

    /*axios.post( 'http://localhost:8080/authenticate',this.state)
        .then((response) => {    
          localStorage.removeItem( "user" )       
          localStorage.setItem( "user", response.data)}).then(this.goHome());  */

    }

    goHome(){
        if(localStorage.getItem('user')){
            this.props.history.push('/stages');
        }
    }

    login() {
         

  
     

       /* fetch('http://localhost:8080/authenticate', {

       /* fetch('http://localhost:8080/authenticate', {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer '
            },
            body: JSON.stringify(this.state)
        }).then((response) => {
            response.json().then((result) => {
                console.log("result ", result);
                console.log(response)
                localStorage.setItem('login', JSON.stringify({
                    login: true,
                    token: result.token
                }));

            })
        })*/
    }


    render() {
        return (
            <div className="formBox">
                <h3>Login</h3>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Email:
                        <input type="email" name="email" value={this.state.email} onChange={this.handleChange} />
                    </label>
                    <label>
                        Password:
                        <input type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                    </label>
                    <button type="sub"> send</button>

                </form>
            </div>
        );
    }
}

