// rest.js
function loadJson(){
    fetch('/rest/lists')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            let html = ''; // Initialize an empty string for HTML content
            data.forEach(customer => {
                html += '<tr>'; // Start a new row
                html += `<td class="customer-name">${customer.username}</td>`; // Add customer name with class
                html += '<td class="reviews"><ul>'; // Start the list of reviews with class
                if (customer.reviews && customer.reviews.length > 0) {
                    customer.reviews.forEach(review => {
                        html += `<li>${review.content}</li>`; // Add each review as a list item
                    });
                } else {
                    html += '<li>No reviews available</li>';
                }
                html += '</ul></td>'; // Close the list and the cell
                html += '</tr>'; // Close the row
            });
            document.getElementById('customerReviews').innerHTML = html;
        })
        .catch(error => console.error('Error fetching customer reviews:', error));
}
