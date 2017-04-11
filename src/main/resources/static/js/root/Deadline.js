var Deadline = function(deadlinePOJO) {
  // monthは 0 ( 1 月 ) から 11 ( 12 月 )
  this.date = new Date(deadlinePOJO.year, deadlinePOJO.month - 1, deadlinePOJO.day);
  this.task = deadlinePOJO.task;
};

Deadline.prototype = {
  toHTML : function() {
    var now = new Date();
    var restMillisec = this.date.getTime() - now.getTime();

    var day      = Math.floor(restMillisec / (1000 * 3600 * 24));
    restMillisec = restMillisec % (1000 * 3600 * 24);

    var hour     = Math.floor(restMillisec / (1000 * 3600));
    restMillisec = restMillisec % (1000 * 3600);

    var minute   = Math.floor(restMillisec / (1000 * 60));
    restMillisec = restMillisec % (1000 * 60);

    var second   = Math.floor(restMillisec / 1000);
    return this.task + 'まで残り' + day + '日' + hour + '時間' + minute + '分' + second + '秒';
  }
};