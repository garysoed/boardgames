goog.provide('bgm.hml.GlobalInfo');

goog.require('bgm.hml.enums');
goog.require('bgm.hml.ui');

bgm.hml.GlobalInfo = function(container) {
  container.html(
      bgm.hml.ui.globalInfo({ 
        turn: 1,
        totalTurn: 20,
        phase: bgm.hml.enums.Phase.DRAFT
  }));
};

