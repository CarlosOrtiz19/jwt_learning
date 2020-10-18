import axios from 'axios'

const baseURL = "http://localhost:8080/";


class LoginService {

    async login(data){
       return  await axios.post(baseURL+'authenticate',data)
        .then((response) => {  
            if(response.data.token)  {
                localStorage.removeItem( "user" )       
                localStorage.setItem( "user", response.data )
            }
            return response.data;
            });  
    }

    logout(){
        localStorage.removeItem("user")
    }

    getCurrentUser() {
        return JSON.parse(localStorage.getItem('user'));;
      }
}

export default new LoginService();

