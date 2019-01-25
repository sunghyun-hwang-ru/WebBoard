export class User {
    userCd: string;
    userPass: string;
    userName: string;
    useYn: string;
    email: string;
    token: string;

    constructor(userCd?: string, userPass?: string, userName?: string, useYn?: string, email?: string) {
      this.userCd = (userCd) ? userCd : '';
      this.userPass = (userPass) ?  userPass : '';
      this.userName = (userName) ? userName : '';
      this.useYn = (useYn) ? useYn : '';
      this.email = (email) ? email : '';
    }

    reset(): void {
        this.userCd = '';
        this.userPass = '';
        this.userName = '';
        this.useYn = '';
        this.email = '';
      }
}
