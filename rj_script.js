
    let order = [];
    let total = 0;
    
    function addItem(itemName, price) {
      order.push({ name: itemName, price: price });
      total += price;
      
      updateOrderList();
      updateTotal();
    }
    
    function updateOrderList() {
      const orderList = document.getElementById('order-list');
      orderList.innerHTML = '';
      
      for (let i = 0; i < order.length; i++) {
        const item = order[i];
        const orderItem = document.createElement('div');
        orderItem.className = 'order-item';
        orderItem.innerHTML = `
          <span>${item.name}</span>
          <span>$${item.price.toFixed(2)}</span>
        `;
        orderList.appendChild(orderItem);
      }
    }
    
    function updateTotal() {
      const totalElement = document.getElementById('total');
      totalElement.textContent = `Total: $${total.toFixed(2)}`;
    }