bgm.namespace("bgm.hml.hangout.GlobalInfo");

bgm.hml.hangout.GlobalInfo = function(container) {
  container.html(
      bgm.hml.hangout.globalInfo({ 
        turn: 1,
        totalTurn: 20,
        phase: bgm.hml.hangout.Phase.DRAFT
  }));
};

