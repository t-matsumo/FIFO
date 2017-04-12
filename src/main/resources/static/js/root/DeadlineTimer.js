var DeadlineTimer = function(deadlinePOJOs) {
  this.DEADLINE_DIV = document.getElementById('deadline');
  this.deadlines    = [];
  
  deadlinePOJOs.forEach(deadlinePOJO => {
    this.deadlines.push(new Deadline(deadlinePOJO));
  });

  this.start();
};

DeadlineTimer.prototype = {
  start : function() {
    this.draw();

    setInterval(() => {
      this.clean();
      this.draw();
    }, 1000);
  },

  clean : function() {
    while (this.DEADLINE_DIV.firstChild) {
      this.DEADLINE_DIV.removeChild(this.DEADLINE_DIV.firstChild);
    }
  },

  draw : function() {
    this.deadlines.forEach(deadline => {
      var div = document.createElement('div');
      div.innerHTML = deadline.toHTML(); 

      this.DEADLINE_DIV.appendChild(div);
    });
  }
};