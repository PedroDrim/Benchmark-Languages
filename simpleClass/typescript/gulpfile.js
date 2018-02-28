var gulp = require("gulp");
var del = require("del");
var browserify = require('browserify');
var babelify = require('babelify');
var buffer = require('vinyl-buffer');
var source = require('vinyl-source-stream');
var tslint = require("gulp-tslint");
var uglify = require("gulp-uglify");
var ts = require("gulp-typescript");
var tsProject = ts.createProject("tsconfig.json");

var build_dir = "bin/build";

gulp.task("compile-ts", function () {
    return tsProject.src()
        .pipe(tslint({
            formatter: "msbuild"
        }))
        .pipe(tslint.report())
        .pipe(tsProject()).js
        .pipe(buffer())
        .pipe(uglify())
        .pipe(gulp.dest(build_dir));
});

gulp.task("clean-build", function () {
    return del(build_dir);
});

gulp.task("clean-modules", function () {
    return del("node_modules");
});

gulp.task("default", ["compile-ts"]);
