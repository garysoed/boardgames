function resizeGameArea() {
  $('#gamearea').height($('#root').height() - $('#globalinfo').height());
}

function resizePlayArea() {
  $('#playarea').width($('#gamearea').width() - $('cardinfo').width() - $('tabs').width());
}

$(document).ready(function() {
  bgm.hml.hangout.GlobalInfo($('#globalinfo'));

  var banana = new bgm.hml.hangout.Card(
      'banana',
      ['consumable', 'staple'],
      'base',
      null,
      20);
  $('#hand').append(bgm.hml.hangout.Card.entity(banana));

  // Layout stuff
  $(window).resize(function() {
    resizeGameArea();
    resizePlayArea();
  });
  resizeGameArea();
  resizePlayArea();
});
