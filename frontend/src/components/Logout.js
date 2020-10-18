import React, { Component } from 'react'
import Loginservice from '../service/LoginService'

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
                
            </div>
        )
    }
}
