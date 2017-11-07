package database;

public class TABLE_PlayerData {

  // player info data
  private String name;
  private int week;
  private String home;
  private String team;
  private String pos;

  // defense data
  private int defAst;
  private int defFFum;
  private int defInt;
  private int defSk;
  private int defTkl;

  // fumble data
  private int fumLost;
  private int fumRcvr;
  private int fumTot;
  private int fumTotRcvr;
  private int fumYds;

  // kicking data
  private int kickFgA;
  private int kickFgM;
  private int kickFgYds;
  private int kickTotPFg;
  private int kickExPtAtt;
  private int kickExPtBlk;
  private int kickExPtMade;
  private int kickExPtMiss;
  private int kickExPtOt;
  private int kickRetAvg;
  private int kickRetLng;
  private int kingRetLngTd;
  private int kickRetRet;
  private int kickRetTds;

  // passing data
  private int passAtt;
  private int passCmp;
  private int passInt;
  private int passTds;
  private int passTwoPtAtt;
  private int passYds;

  // punting data
  private int puntAvg;
  private int puntInsTwty;
  private int puntLng;
  private int puntPts;
  private int puntYds;
  private int puntRetAvg;
  private int puntRetLng;
  private int puntRetLngTd;
  private int puntRetRet;
  private int puntRetTds;

  // receiving data
  private int recLng;
  private int recLngTd;
  private int recRec;
  private int recTwoPtAtt;
  private int recTwoPtMade;
  private int recYds;

  // rushing data
  private int rushAtt;
  private int rushLng;
  private int rushLngTd;
  private int rushTds;
  private int rushTwoPtAtt;
  private int rushTwoPtMade;
  private int rushYds;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeek() {
    return week;
  }

  public void setWeek(int week) {
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

  public int getDefAst() {
    return defAst;
  }

  public void setDefAst(int defAst) {
    this.defAst = defAst;
  }

  public int getDefFFum() {
    return defFFum;
  }

  public void setDefFFum(int defFFum) {
    this.defFFum = defFFum;
  }

  public int getDefInt() {
    return defInt;
  }

  public void setDefInt(int defInt) {
    this.defInt = defInt;
  }

  public int getDefSk() {
    return defSk;
  }

  public void setDefSk(int defSk) {
    this.defSk = defSk;
  }

  public int getDefTkl() {
    return defTkl;
  }

  public void setDefTkl(int defTkl) {
    this.defTkl = defTkl;
  }

  public int getFumLost() {
    return fumLost;
  }

  public void setFumLost(int fumLost) {
    this.fumLost = fumLost;
  }

  public int getFumRcvr() {
    return fumRcvr;
  }

  public void setFumRcvr(int fumRcvr) {
    this.fumRcvr = fumRcvr;
  }

  public int getFumTot() {
    return fumTot;
  }

  public void setFumTot(int fumTot) {
    this.fumTot = fumTot;
  }

  public int getFumTotRcvr() {
    return fumTotRcvr;
  }

  public void setFumTotRcvr(int fumTotRcvr) {
    this.fumTotRcvr = fumTotRcvr;
  }

  public int getFumYds() {
    return fumYds;
  }

  public void setFumYds(int fumYds) {
    this.fumYds = fumYds;
  }

  public int getKickFgA() {
    return kickFgA;
  }

  public void setKickFgA(int kickFgA) {
    this.kickFgA = kickFgA;
  }

  public int getKickFgM() {
    return kickFgM;
  }

  public void setKickFgM(int kickFgM) {
    this.kickFgM = kickFgM;
  }

  public int getKickFgYds() {
    return kickFgYds;
  }

  public void setKickFgYds(int kickFgYds) {
    this.kickFgYds = kickFgYds;
  }

  public int getKickTotPFg() {
    return kickTotPFg;
  }

  public void setKickTotPFg(int kickTotPFg) {
    this.kickTotPFg = kickTotPFg;
  }

  public int getKickExPtAtt() {
    return kickExPtAtt;
  }

  public void setKickExPtAtt(int kickExPtAtt) {
    this.kickExPtAtt = kickExPtAtt;
  }

  public int getKickExPtBlk() {
    return kickExPtBlk;
  }

  public void setKickExPtBlk(int kickExPtBlk) {
    this.kickExPtBlk = kickExPtBlk;
  }

  public int getKickExPtMade() {
    return kickExPtMade;
  }

  public void setKickExPtMade(int kickExPtMade) {
    this.kickExPtMade = kickExPtMade;
  }

  public int getKickExPtMiss() {
    return kickExPtMiss;
  }

  public void setKickExPtMiss(int kickExPtMiss) {
    this.kickExPtMiss = kickExPtMiss;
  }

  public int getKickExPtOt() {
    return kickExPtOt;
  }

  public void setKickExPtOt(int kickExPtOt) {
    this.kickExPtOt = kickExPtOt;
  }

  public int getKickRetAvg() {
    return kickRetAvg;
  }

  public void setKickRetAvg(int kickRetAvg) {
    this.kickRetAvg = kickRetAvg;
  }

  public int getKickRetLng() {
    return kickRetLng;
  }

  public void setKickRetLng(int kickRetLng) {
    this.kickRetLng = kickRetLng;
  }

  public int getKingRetLngTd() {
    return kingRetLngTd;
  }

  public void setKingRetLngTd(int kingRetLngTd) {
    this.kingRetLngTd = kingRetLngTd;
  }

  public int getKickRetRet() {
    return kickRetRet;
  }

  public void setKickRetRet(int kickRetRet) {
    this.kickRetRet = kickRetRet;
  }

  public int getKickRetTds() {
    return kickRetTds;
  }

  public void setKickRetTds(int kickRetTds) {
    this.kickRetTds = kickRetTds;
  }

  public int getPassAtt() {
    return passAtt;
  }

  public void setPassAtt(int passAtt) {
    this.passAtt = passAtt;
  }

  public int getPassCmp() {
    return passCmp;
  }

  public void setPassCmp(int passCmp) {
    this.passCmp = passCmp;
  }

  public int getPassInt() {
    return passInt;
  }

  public void setPassInt(int passInt) {
    this.passInt = passInt;
  }

  public int getPassTds() {
    return passTds;
  }

  public void setPassTds(int passTds) {
    this.passTds = passTds;
  }

  public int getPassTwoPtAtt() {
    return passTwoPtAtt;
  }

  public void setPassTwoPtAtt(int passTwoPtAtt) {
    this.passTwoPtAtt = passTwoPtAtt;
  }

  public int getPassYds() {
    return passYds;
  }

  public void setPassYds(int passYds) {
    this.passYds = passYds;
  }

  public int getPuntAvg() {
    return puntAvg;
  }

  public void setPuntAvg(int puntAvg) {
    this.puntAvg = puntAvg;
  }

  public int getPuntInsTwty() {
    return puntInsTwty;
  }

  public void setPuntInsTwty(int puntInsTwty) {
    this.puntInsTwty = puntInsTwty;
  }

  public int getPuntLng() {
    return puntLng;
  }

  public void setPuntLng(int puntLng) {
    this.puntLng = puntLng;
  }

  public int getPuntPts() {
    return puntPts;
  }

  public void setPuntPts(int puntPts) {
    this.puntPts = puntPts;
  }

  public int getPuntYds() {
    return puntYds;
  }

  public void setPuntYds(int puntYds) {
    this.puntYds = puntYds;
  }

  public int getPuntRetAvg() {
    return puntRetAvg;
  }

  public void setPuntRetAvg(int puntRetAvg) {
    this.puntRetAvg = puntRetAvg;
  }

  public int getPuntRetLng() {
    return puntRetLng;
  }

  public void setPuntRetLng(int puntRetLng) {
    this.puntRetLng = puntRetLng;
  }

  public int getPuntRetLngTd() {
    return puntRetLngTd;
  }

  public void setPuntRetLngTd(int puntRetLngTd) {
    this.puntRetLngTd = puntRetLngTd;
  }

  public int getPuntRetRet() {
    return puntRetRet;
  }

  public void setPuntRetRet(int puntRetRet) {
    this.puntRetRet = puntRetRet;
  }

  public int getPuntRetTds() {
    return puntRetTds;
  }

  public void setPuntRetTds(int puntRetTds) {
    this.puntRetTds = puntRetTds;
  }

  public int getRecLng() {
    return recLng;
  }

  public void setRecLng(int recLng) {
    this.recLng = recLng;
  }

  public int getRecLngTd() {
    return recLngTd;
  }

  public void setRecLngTd(int recLngTd) {
    this.recLngTd = recLngTd;
  }

  public int getRecRec() {
    return recRec;
  }

  public void setRecRec(int recRec) {
    this.recRec = recRec;
  }

  public int getRecTwoPtAtt() {
    return recTwoPtAtt;
  }

  public void setRecTwoPtAtt(int recTwoPtAtt) {
    this.recTwoPtAtt = recTwoPtAtt;
  }

  public int getRecTwoPtMade() {
    return recTwoPtMade;
  }

  public void setRecTwoPtMade(int recTwoPtMade) {
    this.recTwoPtMade = recTwoPtMade;
  }

  public int getRecYds() {
    return recYds;
  }

  public void setRecYds(int recYds) {
    this.recYds = recYds;
  }

  public int getRushAtt() {
    return rushAtt;
  }

  public void setRushAtt(int rushAtt) {
    this.rushAtt = rushAtt;
  }

  public int getRushLng() {
    return rushLng;
  }

  public void setRushLng(int rushLng) {
    this.rushLng = rushLng;
  }

  public int getRushLngTd() {
    return rushLngTd;
  }

  public void setRushLngTd(int rushLngTd) {
    this.rushLngTd = rushLngTd;
  }

  public int getRushTds() {
    return rushTds;
  }

  public void setRushTds(int rushTds) {
    this.rushTds = rushTds;
  }

  public int getRushTwoPtAtt() {
    return rushTwoPtAtt;
  }

  public void setRushTwoPtAtt(int rushTwoPtAtt) {
    this.rushTwoPtAtt = rushTwoPtAtt;
  }

  public int getRushTwoPtMade() {
    return rushTwoPtMade;
  }

  public void setRushTwoPtMade(int rushTwoPtMade) {
    this.rushTwoPtMade = rushTwoPtMade;
  }

  public int getRushYds() {
    return rushYds;
  }

  public void setRushYds(int rushYds) {
    this.rushYds = rushYds;
  }
}
