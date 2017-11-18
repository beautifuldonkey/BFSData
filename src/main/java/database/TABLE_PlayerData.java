package database;

public class TABLE_PlayerData {

  // player info data
  private String name;
  private double week;
  private String home;
  private String team;
  private String pos;

  // defense data
  private double defAst;
  private double defFFum;
  private double defInt;
  private double defSk;
  private double defTkl;

  // fumble data
  private double fumLost;
  private double fumRcvr;
  private double fumTot;
  private double fumTotRcvr;
  private double fumYds;

  // kicking data
  private double kickFgA;
  private double kickFgM;
  private double kickFgYds;
  private double kickTotPFg;
  private double kickExPtAtt;
  private double kickExPtBlk;
  private double kickExPtMade;
  private double kickExPtMiss;
  private double kickExPtOt;
  private double kickRetAvg;
  private double kickRetLng;
  private double kickRetLngTd;
  private double kickRetRet;
  private double kickRetTds;

  // passing data
  private double passAtt;
  private double passCmp;
  private double passInts;
  private double passTds;
  private double passTwoPtAtt;
  private double passTwoPtMade;
  private double passYds;

  // punting data
  private double puntAvg;
  private double puntInsTwty;
  private double puntLng;
  private double puntPts;
  private double puntYds;
  private double puntRetAvg;
  private double puntRetLng;
  private double puntRetLngTd;
  private double puntRetRet;
  private double puntRetTds;

  // receiving data
  private double recLng;
  private double recLngTd;
  private double recRec;
  private double recTwoPtAtt;
  private double recTwoPtMade;
  private double recYds;
  private double recTds;

  // rushing data
  private double rushAtt;
  private double rushLng;
  private double rushLngTd;
  private double rushTds;
  private double rushTwoPtAtt;
  private double rushTwoPtMade;
  private double rushYds;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getWeek() {
    return week;
  }

  public void setWeek(double week) {
    this.week = week;
  }

  public String getHome() {
    return home;
  }

  public void setHome(String home) {
    this.home = home;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public String getPos() {
    return pos;
  }

  public void setPos(String pos) {
    this.pos = pos;
  }

  public double getDefAst() {
    return defAst;
  }

  public void setDefAst(double defAst) {
    this.defAst = defAst;
  }

  public double getDefFFum() {
    return defFFum;
  }

  public void setDefFFum(double defFFum) {
    this.defFFum = defFFum;
  }

  public double getDefInt() {
    return defInt;
  }

  public void setDefInt(double defInt) {
    this.defInt = defInt;
  }

  public double getDefSk() {
    return defSk;
  }

  public void setDefSk(double defSk) {
    this.defSk = defSk;
  }

  public double getDefTkl() {
    return defTkl;
  }

  public void setDefTkl(double defTkl) {
    this.defTkl = defTkl;
  }

  public double getFumLost() {
    return fumLost;
  }

  public void setFumLost(double fumLost) {
    this.fumLost = fumLost;
  }

  public double getFumRcvr() {
    return fumRcvr;
  }

  public void setFumRcvr(double fumRcvr) {
    this.fumRcvr = fumRcvr;
  }

  public double getFumTot() {
    return fumTot;
  }

  public void setFumTot(double fumTot) {
    this.fumTot = fumTot;
  }

  public double getFumTotRcvr() {
    return fumTotRcvr;
  }

  public void setFumTotRcvr(double fumTotRcvr) {
    this.fumTotRcvr = fumTotRcvr;
  }

  public double getFumYds() {
    return fumYds;
  }

  public void setFumYds(double fumYds) {
    this.fumYds = fumYds;
  }

  public double getKickFgA() {
    return kickFgA;
  }

  public void setKickFgA(double kickFgA) {
    this.kickFgA = kickFgA;
  }

  public double getKickFgM() {
    return kickFgM;
  }

  public void setKickFgM(double kickFgM) {
    this.kickFgM = kickFgM;
  }

  public double getKickFgYds() {
    return kickFgYds;
  }

  public void setKickFgYds(double kickFgYds) {
    this.kickFgYds = kickFgYds;
  }

  public double getKickTotPFg() {
    return kickTotPFg;
  }

  public void setKickTotPFg(double kickTotPFg) {
    this.kickTotPFg = kickTotPFg;
  }

  public double getKickExPtAtt() {
    return kickExPtAtt;
  }

  public void setKickExPtAtt(double kickExPtAtt) {
    this.kickExPtAtt = kickExPtAtt;
  }

  public double getKickExPtBlk() {
    return kickExPtBlk;
  }

  public void setKickExPtBlk(double kickExPtBlk) {
    this.kickExPtBlk = kickExPtBlk;
  }

  public double getKickExPtMade() {
    return kickExPtMade;
  }

  public void setKickExPtMade(double kickExPtMade) {
    this.kickExPtMade = kickExPtMade;
  }

  public double getKickExPtMiss() {
    return kickExPtMiss;
  }

  public void setKickExPtMiss(double kickExPtMiss) {
    this.kickExPtMiss = kickExPtMiss;
  }

  public double getKickExPtOt() {
    return kickExPtOt;
  }

  public void setKickExPtOt(double kickExPtOt) {
    this.kickExPtOt = kickExPtOt;
  }

  public double getKickRetAvg() {
    return kickRetAvg;
  }

  public void setKickRetAvg(double kickRetAvg) {
    this.kickRetAvg = kickRetAvg;
  }

  public double getKickRetLng() {
    return kickRetLng;
  }

  public void setKickRetLng(double kickRetLng) {
    this.kickRetLng = kickRetLng;
  }

  public double getKickRetLngTd() {
    return kickRetLngTd;
  }

  public void setKickRetLngTd(double kickRetLngTd) {
    this.kickRetLngTd = kickRetLngTd;
  }

  public double getKickRetRet() {
    return kickRetRet;
  }

  public void setKickRetRet(double kickRetRet) {
    this.kickRetRet = kickRetRet;
  }

  public double getKickRetTds() {
    return kickRetTds;
  }

  public void setKickRetTds(double kickRetTds) {
    this.kickRetTds = kickRetTds;
  }

  public double getPassAtt() {
    return passAtt;
  }

  public void setPassAtt(double passAtt) {
    this.passAtt = passAtt;
  }

  public double getPassCmp() {
    return passCmp;
  }

  public void setPassCmp(double passCmp) {
    this.passCmp = passCmp;
  }

  public double getPassInts() {
    return passInts;
  }

  public void setPassInts(double passInts) {
    this.passInts = passInts;
  }

  public double getPassTds() {
    return passTds;
  }

  public void setPassTds(double passTds) {
    this.passTds = passTds;
  }

  public double getPassTwoPtAtt() {
    return passTwoPtAtt;
  }

  public void setPassTwoPtAtt(double passTwoPtAtt) {
    this.passTwoPtAtt = passTwoPtAtt;
  }

  public double getPassTwoPtMade() {
    return passTwoPtMade;
  }

  public void setPassTwoPtMade(double passTwoPtMade) {
    this.passTwoPtMade = passTwoPtMade;
  }

  public double getPassYds() {
    return passYds;
  }

  public void setPassYds(double passYds) {
    this.passYds = passYds;
  }

  public double getPuntAvg() {
    return puntAvg;
  }

  public void setPuntAvg(double puntAvg) {
    this.puntAvg = puntAvg;
  }

  public double getPuntInsTwty() {
    return puntInsTwty;
  }

  public void setPuntInsTwty(double puntInsTwty) {
    this.puntInsTwty = puntInsTwty;
  }

  public double getPuntLng() {
    return puntLng;
  }

  public void setPuntLng(double puntLng) {
    this.puntLng = puntLng;
  }

  public double getPuntPts() {
    return puntPts;
  }

  public void setPuntPts(double puntPts) {
    this.puntPts = puntPts;
  }

  public double getPuntYds() {
    return puntYds;
  }

  public void setPuntYds(double puntYds) {
    this.puntYds = puntYds;
  }

  public double getPuntRetAvg() {
    return puntRetAvg;
  }

  public void setPuntRetAvg(double puntRetAvg) {
    this.puntRetAvg = puntRetAvg;
  }

  public double getPuntRetLng() {
    return puntRetLng;
  }

  public void setPuntRetLng(double puntRetLng) {
    this.puntRetLng = puntRetLng;
  }

  public double getPuntRetLngTd() {
    return puntRetLngTd;
  }

  public void setPuntRetLngTd(double puntRetLngTd) {
    this.puntRetLngTd = puntRetLngTd;
  }

  public double getPuntRetRet() {
    return puntRetRet;
  }

  public void setPuntRetRet(double puntRetRet) {
    this.puntRetRet = puntRetRet;
  }

  public double getPuntRetTds() {
    return puntRetTds;
  }

  public void setPuntRetTds(double puntRetTds) {
    this.puntRetTds = puntRetTds;
  }

  public double getRecLng() {
    return recLng;
  }

  public void setRecLng(double recLng) {
    this.recLng = recLng;
  }

  public double getRecLngTd() {
    return recLngTd;
  }

  public void setRecLngTd(double recLngTd) {
    this.recLngTd = recLngTd;
  }

  public double getRecRec() {
    return recRec;
  }

  public void setRecRec(double recRec) {
    this.recRec = recRec;
  }

  public double getRecTwoPtAtt() {
    return recTwoPtAtt;
  }

  public void setRecTwoPtAtt(double recTwoPtAtt) {
    this.recTwoPtAtt = recTwoPtAtt;
  }

  public double getRecTwoPtMade() {
    return recTwoPtMade;
  }

  public void setRecTwoPtMade(double recTwoPtMade) {
    this.recTwoPtMade = recTwoPtMade;
  }

  public double getRecYds() {
    return recYds;
  }

  public void setRecYds(double recYds) {
    this.recYds = recYds;
  }

  public double getRecTds() {
    return recTds;
  }

  public void setRecTds(double recTds) {
    this.recTds = recTds;
  }

  public double getRushAtt() {
    return rushAtt;
  }

  public void setRushAtt(double rushAtt) {
    this.rushAtt = rushAtt;
  }

  public double getRushLng() {
    return rushLng;
  }

  public void setRushLng(double rushLng) {
    this.rushLng = rushLng;
  }

  public double getRushLngTd() {
    return rushLngTd;
  }

  public void setRushLngTd(double rushLngTd) {
    this.rushLngTd = rushLngTd;
  }

  public double getRushTds() {
    return rushTds;
  }

  public void setRushTds(double rushTds) {
    this.rushTds = rushTds;
  }

  public double getRushTwoPtAtt() {
    return rushTwoPtAtt;
  }

  public void setRushTwoPtAtt(double rushTwoPtAtt) {
    this.rushTwoPtAtt = rushTwoPtAtt;
  }

  public double getRushTwoPtMade() {
    return rushTwoPtMade;
  }

  public void setRushTwoPtMade(double rushTwoPtMade) {
    this.rushTwoPtMade = rushTwoPtMade;
  }

  public double getRushYds() {
    return rushYds;
  }

  public void setRushYds(double rushYds) {
    this.rushYds = rushYds;
  }
}
