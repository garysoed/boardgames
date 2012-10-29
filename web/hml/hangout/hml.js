$(document).ready(function() {
  bgm.hml.hangout.GlobalInfo($('#globalinfo'));

  var banana = new bgm.hml.hangout.Card(
      'banana',
      ['consumable', 'staple'],
      'base',
      null,
      20);
  var cardZoom = $(bgm.hml.hangout.ui.cardZoom({ card: banana }));
  $('#cardinfo').html(cardZoom);
  var cardWidth = cardZoom.width();
  var cardHeight = cardWidth * 3 / 2;
  cardZoom.css({ 'height': cardHeight + 'px' });
});
