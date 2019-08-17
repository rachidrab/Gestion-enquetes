

var select= document.getElementsByTagName('select')[0];//important le [0], spour dire qu'on prend le premier select trouvé!
select.onchange = function(){
 var p = document.getElementById('toHide');
 if(this.value=='cm') p.style.display='';
 else p.style.display = 'none';
}