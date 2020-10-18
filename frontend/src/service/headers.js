export function header (){
  const user = JSON.parse(localStorage.getItem('user'));


    
    return { Authorization: 'Bearer ' + user.token };

}