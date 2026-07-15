SUMMARY = "nInvaders recipe"
DESCRIPTION = "Space Invaders clone"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/doctorfree/ninvaders.git;branch=main;protocol=https"

#SRCREV = "${AUTOREV}"
SRCREV = "dc38ab8db9ecdb5f69fbd3b3deb42e253d6f08c3"

S = "${WORKDIR}/git"

DEPENDS += "ncurses cmake"

inherit cmake

do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/ninvaders ${D}${bindir}/ninvaders
    install -d ${D}${datadir}/ninvaders
    install -m 0644 ${S}/LICENSE ${D}${datadir}/ninvaders/
    install -m 0644 ${S}/README.md ${D}${datadir}/ninvaders/
    install -m 0644 ${S}/VERSION ${D}${datadir}/ninvaders/
    install -m 0644 ${S}/ChangeLog ${D}${datadir}/ninvaders/
    touch ${D}${datadir}/ninvaders/highscore
}
