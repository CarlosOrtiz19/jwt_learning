import React, { Component } from 'react'
import Loginservice from '../service/LoginService'
import EmployeurRegister from './EmployeurRegister';
import Login from './Login'

export default class Logout extends Component {
    constructor(props) {
        super(props);

    }

    componentDidMount(){
        Loginservice.logout()
       

    }
    render() {
        return (
            <div>
                <EmployeurRegister/>
            </div>
        )
    }
}
