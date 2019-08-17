document.querySelector('#add').addEventListener('click', function(event) {
  
  var first = document.querySelector('table tbody tr:first-child');
  first.parentNode.appendChild(first.cloneNode(true));
  
});