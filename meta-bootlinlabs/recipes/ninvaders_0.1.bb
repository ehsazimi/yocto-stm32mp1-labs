SUMMARY = "nInvaders recipe"
DESCRIPTION = "Space Invaders clone"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/doctorfree/ninvaders.git;branch=main;protocol=https"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS += "ncurses cmake"

inherit cmake

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/ninvaders ${D}${bindir}/ninvaders
    install -d ${D}${datadir}/ninvaders
    install -m 0644 ${S}/LICENSE ${D}${datadir}/ninvaders/
    install -m 0644 ${S}/README.md ${D}${datadir}/ninvaders/
    install -m 0644 ${S}/VERSION ${D}${datadir}/ninvaders/
    install -m 0644 ${S}/ChangeLog ${D}${datadir}/ninvaders/
    touch ${D}${datadir}/ninvaders/highscore
}